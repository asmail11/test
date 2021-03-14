import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { AddIngredientComponent } from '../add-ingredient/add-ingredient.component';
import { IngredientService } from '../../../service/ingredient.service';
import { IngredientDto } from 'src/app/modal/rest';
import { DetailsIngredientComponent } from '../details-ingredient/details-ingredient.component';

@Component({
  selector: 'app-display-ingredient',
  templateUrl: './display-ingredient.component.html',
  styleUrls: ['./display-ingredient.component.scss']
})
export class DisplayIngredientComponent implements OnInit {
  products: IngredientDto[];
  progressBar = false;
  displayIngredient: number;
 
   constructor(private ingredientService: IngredientService, private dialog: MatDialog,
     private snackBar: MatSnackBar) { }
 
   ngOnInit(): void {
     this.ingredientService.findIngredients().subscribe((products) => {
       this.products = products;
     })
   }
   editProduct(idIngredient: number) {
     const dialogRef = this.dialog.open(AddIngredientComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
       data: {idIngredient}
     });
   }
 
   detailProduct(idIngredient: number): void {
     const dialogRef = this.dialog.open(DetailsIngredientComponent, {
      panelClass: 'details-dialog-container',
       data: {idIngredient}
     });
   }
 
   deleteProduct(id: number) {
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
         this.ingredientService.deleteIngredient(id).subscribe(() => {
           this.progressBar = false;
           this.snackBar
           .open('Ingredient deleted with successfully.', 'ok',
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

