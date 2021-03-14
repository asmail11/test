import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { IngredientDto } from 'src/app/modal/rest';
import { IngredientService } from '../../../service/ingredient.service';

@Component({
  selector: 'app-add-ingredient',
  templateUrl: './add-ingredient.component.html',
  styleUrls: ['./add-ingredient.component.scss']
})
export class AddIngredientComponent implements OnInit {
  progressBar = false;
  showNameExists = false;
  productDto: IngredientDto = {} as IngredientDto;

  constructor(
    private ingredientService: IngredientService,
    @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar,
    public matDialogRef: MatDialogRef<AddIngredientComponent>) { }

  ngOnInit(): void {
    if (this.data.idIngredient != null) {
      this.ingredientService.findIngredient(this.data.idIngredient).subscribe((productDto) => {
        this.productDto = productDto;
      })
    }
  }
  addProduct(): void {
    this.progressBar = true;

    if (this.data.idIngredient != null) {
      this.ingredientService.editIngredient(this.productDto, this.data.idIngredient).subscribe((productDto) => {
        this.productDto = productDto;
        this.snackBar
          .open(
            this.productDto.name + ' updated with successfully.',
            'ok',
            { duration: 1000, panelClass: ['mat-toolbar', 'mat-primary'] }
          )
          .afterDismissed()
          .pipe(delay(0))
          .subscribe(() => {
            window.location.reload();
          });
        this.matDialogRef.close();
      })
    } else {
      this.ingredientService.ingredientNameExists(this.productDto.name).subscribe((data) => {
        if (data == false) {
          this.ingredientService.addIngredient(this.productDto).subscribe((productDto) => {
            this.productDto = productDto;
            this.snackBar
              .open(
                this.productDto.name + ' added with successfully.',
                'ok',
                { duration: 1000, panelClass: ['mat-toolbar', 'mat-primary'] }
              )
              .afterDismissed()
              .pipe(delay(0))
              .subscribe(() => {
                window.location.reload();
              });
            this.matDialogRef.close();
          })
        } else {
          this.showNameExists = true;
        }
      })
    }
  }
}
