import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { EssentialOilDto } from '../../../modal/rest';
import { EssentialOilService } from '../../../service/essential-oil.service';

@Component({
  selector: 'app-add-essential',
  templateUrl: './add-essential.component.html',
  styleUrls: ['./add-essential.component.scss']
})
export class AddEssentialComponent implements OnInit {
  showNameExists = false;
  progressBar = false;
  essentialOilDto: EssentialOilDto = {} as EssentialOilDto;

  constructor(private essentialOilService: EssentialOilService, @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar,
    public matDialogRef: MatDialogRef<AddEssentialComponent>) { }

  ngOnInit(): void {
    if (this.data.idEssential != null) {
      this.essentialOilService.findEssentialOil(this.data.idEssential).subscribe((essentialOilDto) => {
        this.essentialOilDto = essentialOilDto;
      })
    }
  }
  addEssential() {
    this.progressBar = true;
    if (this.data.idEssential != null) {
      this.essentialOilService.editEssentialOil(this.essentialOilDto, this.data.idEssential).subscribe((essentialOilDto) => {
        this.essentialOilDto = essentialOilDto;
        this.snackBar
          .open(
            this.essentialOilDto.name + ' updated with successfully.',
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
      this.essentialOilService.essentialOilNameExists(this.essentialOilDto.name).subscribe((data) => {
        if (data == false) {
          this.essentialOilService.addEssentialOil(this.essentialOilDto).subscribe((essentialOilDto) => {
            this.essentialOilDto = essentialOilDto;
            this.snackBar
              .open(
                this.essentialOilDto.name + ' added with successfully.',
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
