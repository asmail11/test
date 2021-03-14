export class Alert {
  type: AlertType;
  message: string;
  alertId: string;
  keepAfterRouteChange: boolean;

  constructor(init?: Partial<Alert>) {
    (Object as any).assign(this, init);
  }
}

export enum AlertType {
  Success,
  Error,
  Info,
  Warning
}
