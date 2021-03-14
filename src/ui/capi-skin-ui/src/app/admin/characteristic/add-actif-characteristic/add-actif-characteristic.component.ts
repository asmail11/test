import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { ActifDto } from 'src/app/modal/rest';
import { ActifService } from 'src/app/service/actif.service';
import { TypeService } from 'src/app/service/type.service';
import { CharacteristicService } from '../../../service/characteristic.service';

@Component({
  selector: 'app-add-actif-characteristic',
  templateUrl: './add-actif-characteristic.component.html',
  styleUrls: ['./add-actif-characteristic.component.scss']
})
export class AddActifCharacteristicComponent implements OnInit {
  idProduct: number;
  progressBar = false;
  products: ActifDto[]
  productsFilter: ActifDto[];

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private actifService: ActifService,
    private snackBar: MatSnackBar, private characteristicService: CharacteristicService,
    public matDialogRef: MatDialogRef<AddActifCharacteristicComponent>) { }

  ngOnInit(): void {
    this.actifService.finActifs().subscribe((products) => {
      this.products = products;
      this.characteristicService.findActifsForCharacteristic(this.data.idCharacteristic).subscribe((productsFilter) => {
        this.productsFilter = productsFilter;
        this.productsFilter.forEach(value => {
          this.products = this.products.filter(a => a.id !== value.id);
        })
      })
    })

  }
  onSelectProduct(e): void {
    this.idProduct = e.target.value;
    console.log(this.idProduct)
  }
  addProductToType(idProduct: number) {
    this.characteristicService.addActifToCharacteristic(this.data.idCharacteristic, idProduct).subscribe(() => {
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
