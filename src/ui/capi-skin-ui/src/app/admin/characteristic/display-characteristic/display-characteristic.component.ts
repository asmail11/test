import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { CharacteristicDto } from '../../../modal/rest';
import { CharacteristicService } from '../../../service/characteristic.service';
import { ConfirmDialogModel } from '../../../confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { AddNeedComponent } from '../../needs/add-need/add-need.component';
import { AddCharacteristicComponent } from '../add-characteristic/add-characteristic.component';
import { AddIngredientComponent } from '../../ingredient/add-ingredient/add-ingredient.component';
import { AddActifCharacteristicComponent } from '../add-actif-characteristic/add-actif-characteristic.component';
import { AddEssentialCharacteristicComponent } from '../add-essential-characteristic/add-essential-characteristic.component';
import { AddIngredeintCharacteristicComponent } from '../add-ingredeint-characteristic/add-ingredeint-characteristic.component';

@Component({
  selector: 'app-display-characteristic',
  templateUrl: './display-characteristic.component.html',
  styleUrls: ['./display-characteristic.component.scss']
})
export class DisplayCharacteristicComponent implements OnInit {
  characteristicDto: CharacteristicDto = {} as CharacteristicDto;
  idCharacteristic: number;
  progressBar = false;
  idBody: number;

  constructor(private characteristicService: CharacteristicService, private route: ActivatedRoute,
    private dialog: MatDialog, private snackBar: MatSnackBar) {
    this.route.params.subscribe(
      params => {
        this.idCharacteristic = this.route.snapshot.params.idCharacteristic;
        this.idBody = this.route.parent.snapshot.params.idBody;
        this.characteristicService.findCharacteristic(this.idCharacteristic).subscribe((characteristicDto) => {
          this.characteristicDto = characteristicDto;
        })
      }
    )
  }

  ngOnInit(): void {
  }

  editCharacteristic(idCharacteristic: number) {
    const dialogRef = this.dialog.open(AddCharacteristicComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idCharacteristic }
    });
  }
  deleteCharacteristic(idCharacteristic: number) {
    const message = `Are you sure you want to delete this category ?`;
    const dialogData = new ConfirmDialogModel('Confirm deleting', message);
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      maxWidth: '420px',
      data: dialogData,
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.progressBar = true;
        this.characteristicService.deleteCharacteristic(idCharacteristic).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Ingredient deleted with successfully.', 'ok',
              {
                duration: 1500,
                panelClass: ['mat-toolbar', 'mat-primary']
              })
            .afterDismissed()
            .pipe(delay(0))
            .subscribe(() => {
              window.location.replace(`/tree-application/${this.route.parent.snapshot.params.idBody}`)
            })
        });
      }
    });
  }

  addNeeds(idCharacteristic: number) {
    const dialogRef = this.dialog.open(AddNeedComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idCharacteristic }
    });
   }
   addIngredientForType(idCharacteristic: number) {
    const dialogRef = this.dialog.open(AddIngredeintCharacteristicComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idCharacteristic }
    });
  }
  addActifForType(idCharacteristic: number) {
    const dialogRef = this.dialog.open(AddActifCharacteristicComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idCharacteristic }
    });
  }
  addEssentialForType(idCharacteristic: number) {
    const dialogRef = this.dialog.open(AddEssentialCharacteristicComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idCharacteristic }
    });
  }
}


