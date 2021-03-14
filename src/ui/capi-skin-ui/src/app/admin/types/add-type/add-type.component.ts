import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { TypeDto } from '../../../modal/rest';
import { TypeService } from '../../../service/type.service';
import { AddBodyFaceHairComponent } from '../../body-face-hair/add-body-face-hair/add-body-face-hair.component';

@Component({
  selector: 'app-add-type',
  templateUrl: './add-type.component.html',
  styleUrls: ['./add-type.component.scss']
})
export class AddTypeComponent implements OnInit {
  progressBar = false;
  showNameExists = false;
  typeDto: TypeDto = {} as TypeDto;

  constructor(private typeService: TypeService, @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar, public matDialogRef: MatDialogRef<AddBodyFaceHairComponent>) { }

  ngOnInit(): void {
    if (this.data.idType != null) {
      this.typeService.findType(this.data.idType).subscribe((typeDto) => {
        this.typeDto = typeDto;
      })
    }

  }

  addType() {
    this.progressBar = true;
    if (this.data.idType != null) {
      this.typeService.editType(this.typeDto, this.data.idType).subscribe((typeDto) => {
        this.typeDto = typeDto;
        this.snackBar
          .open(
            this.typeDto.name + ' added with successfully.',
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
    } else {
      this.typeService.typeNameExists(this.typeDto.name).subscribe(() => {
        this.showNameExists = true;
      })
      this.typeService.addType(this.typeDto, this.data.idBody).subscribe((typeDto) => {
        this.typeDto = typeDto;
        this.snackBar
          .open(
            this.typeDto.name + ' added with successfully.',
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
}
