import { Component, OnInit, Inject } from '@angular/core';
import { CharacteristicDto } from '../../../modal/rest';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CharacteristicService } from '../../../service/characteristic.service';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-add-characteristic',
  templateUrl: './add-characteristic.component.html',
  styleUrls: ['./add-characteristic.component.scss']
})
export class AddCharacteristicComponent implements OnInit {
  progressBar = false;
  showNameExists = false;
  characteristicDto: CharacteristicDto = {} as CharacteristicDto;


  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private characteristicService: CharacteristicService,
    private snackBar: MatSnackBar, public matDialogRef: MatDialogRef<AddCharacteristicComponent>) { }

  ngOnInit(): void {
    if (this.data.idCharacteristic != null) {
      this.characteristicService.findCharacteristic(this.data.idCharacteristic).subscribe((characteristicDto) => {
        this.characteristicDto = characteristicDto;
      })
    }
  }
  addCharacteristicDto() {
    this.progressBar = true;
    if (this.data.idCharacteristic != null) {
      this.characteristicService.editCharacteristic(this.characteristicDto, this.data.idCharacteristic).subscribe((characteristicDto) => {
        this.characteristicDto = characteristicDto;
        this.snackBar
          .open(
            this.characteristicDto.name + ' updated with successfully.',
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
      this.characteristicService.characteristicNameExists(this.characteristicDto.name).subscribe(() => {
        this.showNameExists = true;
      })
      this.characteristicService.addCharacteristic(this.characteristicDto, this.data.idType).subscribe((characteristicDto) => {
        this.characteristicDto = characteristicDto;
        this.snackBar
          .open(
            this.characteristicDto.name + ' added with successfully.',
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


