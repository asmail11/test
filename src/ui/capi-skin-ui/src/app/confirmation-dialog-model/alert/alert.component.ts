import { Component, Input, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Alert, AlertType } from './Alert.';
import { AlertService } from './alert.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {
  @Input() id: string;
  alerts: Alert[] = [];
  subscription: Subscription;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.subscription = this.alertService.onAlert(this.id)
      .subscribe(alert => {
        if (!alert.message) {
          // clear alerts when an empty alert is received
          this.alerts = [];
          return;
        }

        // add alert to array
        this.alerts.push(alert);
      });
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy() {
    // unsubscribe to avoid memory leaks
    this.subscription.unsubscribe();
  }

  removeAlert(alert: Alert) {
    // remove specified alert from array
    this.alerts = this.alerts.filter(x => x !== alert);
   // window.location.reload();
  }

  cssClass(alert: Alert) {
    if (!alert) {
      return;
    }

    // return css class based on alert type
    switch (alert.type) {
      case AlertType.Success:
        return 'alert alert-success';
      case AlertType.Error:
        return 'alert alert-danger';
      case AlertType.Info:
        return 'alert alert-info';
      case AlertType.Warning:
        return 'alert alert-warning';
    }
  }
}
