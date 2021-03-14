import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { BaseProductDto } from 'src/app/modal/rest';
import { BaseProductService } from 'src/app/service/base-product.service';
import { AddBaseProductComponent } from '../add-base-product/add-base-product.component';

@Component({
  selector: 'app-display-base-product',
  templateUrl: './display-base-product.component.html',
  styleUrls: ['./display-base-product.component.scss']
})
export class DisplayBaseProductComponent implements OnInit {
  baseProductDto: BaseProductDto = {} as BaseProductDto;
  idBase: number;
  progressBar = false;

  constructor(private baseProductService: BaseProductService, private route: ActivatedRoute,
    private dialog: MatDialog, private snackBar: MatSnackBar) {
    this.route.params.subscribe(
      params => {
        this.idBase = this.route.snapshot.params.idBase;
        this.baseProductService.findBaseProduct(this.idBase).subscribe((baseProductDto) => {
         this.baseProductDto = baseProductDto;
        })
      }
    )
  }

  ngOnInit(): void {
  }

  editBaseProduct(idBase: number): void {
    const dialogRef = this.dialog.open(AddBaseProductComponent, {
      data: {idBase},
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
    });
  }

  deleteBaseProduct(idBase: number): void {
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
        this.baseProductService.deleteBaseProduct(idBase).subscribe(() => {
          this.progressBar = false;
          this.snackBar
          .open('Base product deleted with successfully.', 'ok',
          { duration: 1500,
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
}
