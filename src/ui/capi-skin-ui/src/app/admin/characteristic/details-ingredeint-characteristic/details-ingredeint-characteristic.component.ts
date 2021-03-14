import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { IngredientDto, ActifDto, EssentialOilDto, TypeDto } from 'src/app/modal/rest';
import { CharacteristicService } from 'src/app/service/characteristic.service';
import { DetailsActifComponent } from '../../actif/details-actif/details-actif.component';
import { DetailsEssentialComponent } from '../../essential/details-essential/details-essential.component';
import { DetailsIngredientComponent } from '../../ingredient/details-ingredient/details-ingredient.component';
import { CharacteristicDto } from '../../../modal/rest';

@Component({
  selector: 'app-details-ingredeint-characteristic',
  templateUrl: './details-ingredeint-characteristic.component.html',
  styleUrls: ['./details-ingredeint-characteristic.component.scss']
})
export class DetailsIngredeintCharacteristicComponent implements OnInit {
  products: IngredientDto[] = [];
  actifs: ActifDto[] = [];
  essentials: EssentialOilDto[] = [];
  characteristicDto: CharacteristicDto = {} as CharacteristicDto;
  progressBar = false;
  idCharacteristic: number;
  actifsLength = 0;
  productsLength = 0;
  essentialsLength = 0;
 
   constructor(private characteristicService: CharacteristicService, private dialog: MatDialog,
     private snackBar: MatSnackBar, private route: ActivatedRoute) { }
 
   ngOnInit(): void {
    this.idCharacteristic = this.route.parent.snapshot.params.idCharacteristic;
    this.characteristicService.findCharacteristic(this.idCharacteristic).subscribe((characteristicDto) => {
     this.characteristicDto = characteristicDto;
    })
     this.characteristicService.findActifsForCharacteristic(this.idCharacteristic).subscribe((actifs) => {
       this.actifs = actifs;
       this.actifsLength = this.actifs.length;
     })
     this.characteristicService.findEssentialOilsForCharacteristic(this.idCharacteristic).subscribe((essentials) => {
      this.essentials = essentials;
      this.essentialsLength = this.essentials.length;
    })
     this.characteristicService.findProductsForCharacteristic(this.idCharacteristic).subscribe((products) => {
      this.products = products;
      this.productsLength = this.products.length;
    })
   }

   removeActifFromCharacteristic(idCharacteristic: number, idActif: number) {
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
        this.characteristicService.removeActifFromCharacteristic(idCharacteristic, idActif).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Actif deleted with successfully.', 'ok',
              {
                duration: 1000,
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
  removeEssentialFromCharacteristic(idCharacteristic: number, idEssential: number) {
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
        this.characteristicService.removeEssentialFromCharacteristic(idCharacteristic, idEssential).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Ingredient deleted with successfully.', 'ok',
              {
                duration: 1000,
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
   detailProduct(idIngredient: number): void {
     const dialogRef = this.dialog.open(DetailsIngredientComponent, {
      panelClass: 'details-dialog-container',
       data: {idIngredient}
     });
   }
 
   removeProductFromCharacteristic(idCharacteristic: number, idIngredient: number) {
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
         this.characteristicService.removeProductFromCharacteristic(idCharacteristic, idIngredient).subscribe(() => {
           this.progressBar = false;
           this.snackBar
           .open('Ingredient deleted with successfully.', 'ok',
           { duration: 1000,
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
