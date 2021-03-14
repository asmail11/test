import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { BodyFaceHairDto } from '../../../modal/rest';
import { BodyFaceHairService } from '../../../service/body-face-hair.service';

@Component({
  selector: 'app-add-body-face-hair',
  templateUrl: './add-body-face-hair.component.html',
  styleUrls: ['./add-body-face-hair.component.scss']
})
export class AddBodyFaceHairComponent implements OnInit {
  progressBar = false;
  showNameExists = false;
  bodyFaceHairDto: BodyFaceHairDto = {} as BodyFaceHairDto;

  constructor(private bodyFaceHairService: BodyFaceHairService, @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar,
    public matDialogRef: MatDialogRef<AddBodyFaceHairComponent>) { }

  ngOnInit(): void {
    if (this.data.idBody != null) {
      this.bodyFaceHairService.findBodyFaceHair(this.data.idBody).subscribe((bodyFaceHairDto) => {
        this.bodyFaceHairDto = bodyFaceHairDto;
      })
    }
  }
  addBodyFaceHair() {
    this.progressBar = true;
    if (this.data.idBody != null) {
      this.bodyFaceHairService.editBodyFaceHair(this.bodyFaceHairDto, this.data.idBody).subscribe((bodyFaceHairDto) => {
        this.bodyFaceHairDto = bodyFaceHairDto;
        this.snackBar
          .open(
            this.bodyFaceHairDto.name + ' added with successfully.',
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
      this.bodyFaceHairService.bodyAndHairNameExists(this.bodyFaceHairDto.name).subscribe((data) => {
        if (data == false) {
          this.bodyFaceHairService.addBodyFaceHair(this.bodyFaceHairDto).subscribe((bodyFaceHairDto) => {
            this.bodyFaceHairDto = bodyFaceHairDto;
            this.snackBar
              .open(
                this.bodyFaceHairDto.name + ' update with successfully.',
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

