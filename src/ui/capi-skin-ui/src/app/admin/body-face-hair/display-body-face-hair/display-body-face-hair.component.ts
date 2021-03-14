import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { BodyFaceHairDto } from '../../../modal/rest';
import { BodyFaceHairService } from '../../../service/body-face-hair.service';
import { AddTypeComponent } from '../../types/add-type/add-type.component';
import { AddBodyFaceHairComponent } from '../add-body-face-hair/add-body-face-hair.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-display-body-face-hair',
  templateUrl: './display-body-face-hair.component.html',
  styleUrls: ['./display-body-face-hair.component.scss']
})
export class DisplayBodyFaceHairComponent implements OnInit {
  category: BodyFaceHairDto = {} as BodyFaceHairDto;
  idBody: number;
  progressBar = false;
  

  constructor(private bodyFaceHairService: BodyFaceHairService, private route: ActivatedRoute,
    private dialog: MatDialog, private snackBar: MatSnackBar) {
    this.route.params.subscribe(
      params => {
        this.idBody = this.route.parent.snapshot.params.idBody;
        this.bodyFaceHairService.findBodyFaceHair(this.idBody).subscribe((category) => {
          this.category = category;
        })
      }
    );
  }

  ngOnInit(): void {
  }

  addType(idBody: number) {
    const dialogRef = this.dialog.open(AddTypeComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idBody}
    });
  }
  addBodyFaceHaire(idBody: number) {
    const dialogRef = this.dialog.open(AddBodyFaceHairComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idBody}
    });
  }
  deleteBodyFaceHaire(idBody: number) {
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
        this.bodyFaceHairService.deleteBodyFaceHair(idBody).subscribe(() => {
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
              window.location.replace(`/dashboard`)
            })
        });
      }
    });
  }
}

