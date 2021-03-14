import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { NeedsDto } from 'src/app/modal/rest';
import { NeedsService } from '../../../service/needs.service';

@Component({
  selector: 'app-add-need',
  templateUrl: './add-need.component.html',
  styleUrls: ['./add-need.component.scss']
})
export class AddNeedComponent implements OnInit {
  progressBar = false;
  showNameExists = false;
  needsDto: NeedsDto = {} as NeedsDto;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private needsService: NeedsService,
    private snackBar: MatSnackBar, public matDialogRef: MatDialogRef<AddNeedComponent>) { }

  ngOnInit(): void {
    if (this.data.idNeed != null) {
      this.needsService.findNeeds(this.data.idNeed).subscribe((needsDto) => {
        this.needsDto = needsDto;
      })
    }
  }
  addNeeds() {
    this.progressBar = true;
    if (this.data.idNeed != null) {
      this.needsService.editNeeds(this.needsDto, this.data.idNeed).subscribe((needsDto) => {
        this.needsDto = needsDto;
        this.snackBar
          .open(
            this.needsDto.name + ' updated with successfully.',
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
      this.needsService.addNeeds(this.needsDto, this.data.idCharacteristic).subscribe((needsDto) => {
        this.needsDto = needsDto;
        this.snackBar
          .open(
            this.needsDto.name + ' added with successfully.',
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
