import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { EssentialOilDto } from 'src/app/modal/rest';
import { EssentialOilService } from 'src/app/service/essential-oil.service';
import { TypeService } from 'src/app/service/type.service';
import { CharacteristicService } from '../../../service/characteristic.service';

@Component({
  selector: 'app-add-essential-characteristic',
  templateUrl: './add-essential-characteristic.component.html',
  styleUrls: ['./add-essential-characteristic.component.scss']
})
export class AddEssentialCharacteristicComponent implements OnInit {
  idProduct: number;
  progressBar = false;
  products: EssentialOilDto[]
  productsFilter: EssentialOilDto[];

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private essentialOilService: EssentialOilService,
    private snackBar: MatSnackBar, private characteristicService: CharacteristicService,
    public matDialogRef: MatDialogRef<AddEssentialCharacteristicComponent>) { }

  ngOnInit(): void {
    this.essentialOilService.findEssentialOils().subscribe((products) => {
      this.products = products;
      this.characteristicService.findEssentialOilsForCharacteristic(this.data.idCharacteristic).subscribe((productsFilter) => {
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
    this.characteristicService.addEssentialToCharacteristic(this.data.idCharacteristic, idProduct).subscribe(() => {
      this.snackBar
        .open(
          'Actif added with successfully.',
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
