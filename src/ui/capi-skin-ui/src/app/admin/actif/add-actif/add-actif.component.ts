import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { ActifDto } from '../../../modal/rest';
import { ActifService } from '../../../service/actif.service';

@Component({
  selector: 'app-add-actif',
  templateUrl: './add-actif.component.html',
  styleUrls: ['./add-actif.component.scss']
})
export class AddActifComponent implements OnInit {
  progressBar = false;
  actifDto: ActifDto = {} as ActifDto;
  showNameExists = false;
  urlPhoto = '(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?';

  constructor(private actifService: ActifService, @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar,
    public matDialogRef: MatDialogRef<AddActifComponent>) { }

  ngOnInit(): void {
    if (this.data.idActif != null) {
      this.actifService.findActif(this.data.idActif).subscribe((actifDto) => {
        this.actifDto = actifDto;
      })
    }
  }
  addActif() {
    this.progressBar = true;
    this.actifService.actifNameExists(this.actifDto.name).subscribe((data) => {
        if (this.data.idActif != null) {
          this.actifService.editActif(this.actifDto, this.data.idActif).subscribe((actifDto) => {
            this.actifDto = actifDto;
            this.snackBar
              .open(
                this.actifDto.name + ' added with successfully.',
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
          if (data == false) {
          this.actifService.addActif(this.actifDto).subscribe((actifDto) => {
            this.actifDto = actifDto;
            this.snackBar
              .open(
                this.actifDto.name + ' updated with successfully.',
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
      } 
    });
  }
}
