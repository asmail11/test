import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { NeedsDto } from 'src/app/modal/rest';
import { NeedsService } from 'src/app/service/needs.service';
import { AddBaseProductComponent } from '../../base-product/add-base-product/add-base-product.component';
import { AddNeedComponent } from '../add-need/add-need.component';

@Component({
  selector: 'app-display-need',
  templateUrl: './display-need.component.html',
  styleUrls: ['./display-need.component.scss']
})
export class DisplayNeedComponent implements OnInit {
  needsDto: NeedsDto = {} as NeedsDto;
  idNeed: number;
  progressBar =  false;
  idCategory: number;

  constructor(private needsService: NeedsService, private route: ActivatedRoute,
    private dialog: MatDialog, private snackBar: MatSnackBar) {
    this.route.params.subscribe(
      params => {
        this.idNeed = this.route.snapshot.params.idNeed;
        this.idCategory = this.route.parent.snapshot.params.idCategory;
        this.needsService.findNeeds(this.idNeed).subscribe((needsDto) => {
         this.needsDto = needsDto;
        })
      }
    )
  }

  ngOnInit(): void {
  }
  addNeeds(idNeed: number): void {
    const dialogRef = this.dialog.open(AddNeedComponent, {
      data: {idNeed},
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
    });
  }
  deleteNeed(idNeed: number) {
    const message = `Are you sure you want to delete this ?`;
    const dialogData = new ConfirmDialogModel('Confirm deleting', message);
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      maxWidth: '420px',
      data: dialogData,
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.progressBar = true;
        this.needsService.deleteNeeds(idNeed).subscribe(() => {
          this.progressBar = false;
          this.snackBar
          .open('Needs deleted with successfully.', 'ok',
          { duration: 1500,
            panelClass: ['mat-toolbar', 'mat-primary']
           })
          .afterDismissed()
          .pipe(delay(0))
          .subscribe(() => {
            window.location.replace(`/tree-application/${this.route.parent.snapshot.params.idCategory}`)
          })
      });
    }
  });
  }
  addBaseProduct(idNeed: number) {
    const dialogRef = this.dialog.open(AddBaseProductComponent, {
      data: {idNeed},
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
    });
  }
}
