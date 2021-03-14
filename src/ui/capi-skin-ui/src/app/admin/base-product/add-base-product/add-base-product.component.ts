import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { BaseProductDto } from 'src/app/modal/rest';
import { BaseProductService } from '../../../service/base-product.service';

@Component({
  selector: 'app-add-base-product',
  templateUrl: './add-base-product.component.html',
  styleUrls: ['./add-base-product.component.scss']
})
export class AddBaseProductComponent implements OnInit {
  progressBar = false;
  baseProductDto: BaseProductDto = {} as BaseProductDto;
  showNameExists = false;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private baseProductService: BaseProductService,
    private snackBar: MatSnackBar, public matDialogRef: MatDialogRef<AddBaseProductComponent>) { }

  ngOnInit(): void {
    if (this.data.idBase != null) {
      this.baseProductService.findBaseProduct(this.data.idBase).subscribe((baseProductDto) => {
        this.baseProductDto = baseProductDto;
      })
    }
  }
  addBaseProduct() {
    this.progressBar = true;
    if (this.data.idBase != null) {
      this.baseProductService.editBaseProduct(this.baseProductDto, this.data.idBase).subscribe((baseProductDto) => {
        this.baseProductDto = baseProductDto;
        this.snackBar
          .open(this.baseProductDto.name + ' updated with successfully.', 'ok',
            {
              duration: 1500,
              panelClass: ['mat-toolbar', 'mat-primary']
            })
          .afterDismissed()
          .pipe(delay(0))
          .subscribe(() => {
            window.location.reload();
          })
        this.matDialogRef.close();
      })
    } else {
      this.baseProductService.addBaseProduct(this.baseProductDto, this.data.idNeed).subscribe((baseProductDto) => {
        this.baseProductDto = baseProductDto;
        this.snackBar
          .open(this.baseProductDto.name + ' added with successfully.', 'ok',
            {
              duration: 1500,
              panelClass: ['mat-toolbar', 'mat-primary']
            })
          .afterDismissed()
          .pipe(delay(0))
          .subscribe(() => {
            window.location.reload();
          })
        this.matDialogRef.close();
      })
    }
  }

}
