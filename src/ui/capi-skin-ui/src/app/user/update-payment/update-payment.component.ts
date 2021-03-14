import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PaymentDto } from 'src/app/modal/rest';
import { CryptogrammeInfoComponent } from '../cryptogramme-info/cryptogramme-info.component';
import { PaymentService } from '../service/payment.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-update-payment',
  templateUrl: './update-payment.component.html',
  styleUrls: ['./update-payment.component.scss']
})
export class UpdatePaymentComponent implements OnInit {
  paymentDto: PaymentDto = {} as PaymentDto;
  isAddPaymentFailed = false;
  idUser: number;

  constructor(private dialog: MatDialog, @Inject(MAT_DIALOG_DATA) private data: any,
   private paymentService: PaymentService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.paymentService.findPaymentForUser(this.data.idUser).subscribe((paymentDto) => {
       this.paymentDto = paymentDto;
       this.paymentDto.cartNumber = String(this.paymentDto.cartNumber);
       this.paymentDto.cartNumber = this.paymentDto.cartNumber.replace(/\d(?=\d{3})/g, "*"); 
    })
  }
  close() {
    this.dialog.closeAll();
  }
  updatePayment(idPayment: number) {
    this.paymentDto.cartNumber = this.paymentDto.cartNumber;
    this.paymentService.validatedCreditCardNumber(this.paymentDto.cartNumber).subscribe((data) => {
      if(data==true) {
        this.isAddPaymentFailed = false;
        this.paymentService.updatePayment(this.paymentDto, idPayment).subscribe((paymentDto) => {
          this.paymentDto = paymentDto;
          this.snackBar
          .open(
           ' Information saved with successfully.',
            'ok',
            { duration: 500, panelClass: ['mat-toolbar', 'mat-primary'] }
          )
          .afterDismissed()
          .pipe(delay(0))
          .subscribe(() => {
            window.location.reload();
          });
         }) 
       }
       else {
         this.isAddPaymentFailed = true;
        }                 
     }) 
  }
  cartNumberCorrect() {
    this.isAddPaymentFailed = false;
  }
  cryptogrammeInfo() {
    this.dialog.open(CryptogrammeInfoComponent, {
      panelClass: 'auth-dialog-container',
      width: '500px',
      height: '400px'
    });
  }
}


