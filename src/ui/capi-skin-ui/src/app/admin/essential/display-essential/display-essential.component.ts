import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { EssentialOilDto } from 'src/app/modal/rest';
import { EssentialOilService } from '../../../service/essential-oil.service';
import { AddEssentialComponent } from '../add-essential/add-essential.component';
import { DetailsEssentialComponent } from '../details-essential/details-essential.component';

@Component({
  selector: 'app-display-essential',
  templateUrl: './display-essential.component.html',
  styleUrls: ['./display-essential.component.scss']
})
export class DisplayEssentialComponent implements OnInit {
  essentials: EssentialOilDto[];
  progressBar = false;
  displayEssential: number;

  constructor(private essentialOilService: EssentialOilService, private dialog: MatDialog, 
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.essentialOilService.findEssentialOils().subscribe((essentials) => {
      this.essentials = essentials;
    })
  }
editEssential(idEssential: number) {
  const dialogRef = this.dialog.open(AddEssentialComponent, {
    autoFocus: false,
    disableClose: true,
    panelClass: 'add-dialog-container',
    data: {idEssential}
  });
}
deleteEssential(idEssential: number) {
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
      this.essentialOilService.deleteEssentialOil(idEssential).subscribe(() => {
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
detailsEssential(idEssential: number) {
  const dialogRef = this.dialog.open(DetailsEssentialComponent, {
    panelClass: 'details-dialog-container',
    data: {idEssential}
  });
}
}
