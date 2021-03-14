import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { TypeDto } from '../../../modal/rest';
import { TypeService } from '../../../service/type.service';
import { AddTypeComponent } from '../add-type/add-type.component';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddCharacteristicComponent } from '../../characteristic/add-characteristic/add-characteristic.component';

@Component({
  selector: 'app-display-type',
  templateUrl: './display-type.component.html',
  styleUrls: ['./display-type.component.scss']
})
export class DisplayTypeComponent implements OnInit {
  typeDto: TypeDto = {} as TypeDto;
  idType: number;
  idBody: number;
  progressBar = false;

  constructor(private typeService: TypeService, private route: ActivatedRoute,
    private dialog: MatDialog, private snackBar: MatSnackBar) {
    this.route.params.subscribe(
      params => {
        this.idType = this.route.snapshot.params.idType;
        this.idBody = this.route.parent.snapshot.params.idBody;
        this.typeService.findType(this.idType).subscribe((typeDto) => {
          this.typeDto = typeDto;
        })
      }
    );
  }

  ngOnInit(): void {
  }

  editType(idType: number) {
    const dialogRef = this.dialog.open(AddTypeComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idType }
    });
  }
  deleteType(idType: number) {
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
        this.typeService.deleteType(idType).subscribe(() => {
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
  addCharacteristicDto(idType: number) {
    const dialogRef = this.dialog.open(AddCharacteristicComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: { idType }
    });
  }
}

