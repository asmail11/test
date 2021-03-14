import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { IngredientDto } from 'src/app/modal/rest';
import { IngredientService } from 'src/app/service/ingredient.service';
import { TypeService } from 'src/app/service/type.service';
import { CharacteristicService } from '../../../service/characteristic.service';

@Component({
  selector: 'app-add-ingredeint-characteristic',
  templateUrl: './add-ingredeint-characteristic.component.html',
  styleUrls: ['./add-ingredeint-characteristic.component.scss']
})
export class AddIngredeintCharacteristicComponent implements OnInit {
  idProduct: number;
  progressBar = false;
  products: IngredientDto[]
  productsFilter: IngredientDto[];

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private ingredientService: IngredientService,
    private snackBar: MatSnackBar, private characteristicService: CharacteristicService,
    public matDialogRef: MatDialogRef<AddIngredeintCharacteristicComponent>) { }

  ngOnInit(): void {
    this.ingredientService.findIngredients().subscribe((products) => {
      this.products = products;
      this.characteristicService.findProductsForCharacteristic(this.data.idCharacteristic).subscribe((productsFilter) => {
        this.productsFilter = productsFilter;
        this.productsFilter.forEach(value => {
          this.products = this.products.filter(a => a.id !== value.id);
        })
      })
    })

  }
  onSelectProduct(e): void {
    this.idProduct = e.target.value;
  }
  addProductToType(idProduct: number) {
    this.characteristicService.addProductToCharacteristic(this.data.idCharacteristic, idProduct).subscribe(() => {
      this.snackBar
        .open(
          'Product added with successfully.',
          'ok',
          { duration: 1500, panelClass: ['mat-toolbar', 'mat-primary'] }
        )
        .afterDismissed()
        .pipe(delay(0))
        .subscribe(() => {
          window.location.reload();
        });
      this.matDialogRef.close();
    })
  }
}
