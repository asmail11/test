import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { ActifDto } from 'src/app/modal/rest';
import { ActifService } from '../../../service/actif.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddActifComponent } from '../add-actif/add-actif.component';
import { DetailsActifComponent } from '../details-actif/details-actif.component';

@Component({
  selector: 'app-display-actif',
  templateUrl: './display-actif.component.html',
  styleUrls: ['./display-actif.component.scss']
})
export class DisplayActifComponent implements OnInit {
  actifs: ActifDto[];
  progressBar = false;
  public pageSize = 10;
  public currentPage = 0;
  public totalSize = 0;
  pageEvent: any;
  displayActif: number;

  constructor(private dialog: MatDialog, private actifService: ActifService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.actifService.finActifs().subscribe((actifs) => {
      this.actifs = actifs;
    })
  }
  editActif(idActif: number) {
    const dialogRef = this.dialog.open(AddActifComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idActif}
    });
  }
  deleteActif(id: number) {
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
        this.actifService.deleteActif(id).subscribe(() => {
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
              window.location.reload();
            })
        });
      }
    });
  }

  detailActif(idActif: number) {
    const dialogRef = this.dialog.open(DetailsActifComponent, {
      panelClass: 'details-dialog-container',
      data: {idActif}
    });
  }
}
