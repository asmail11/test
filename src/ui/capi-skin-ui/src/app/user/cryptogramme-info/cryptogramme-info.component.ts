import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-cryptogramme-info',
  templateUrl: './cryptogramme-info.component.html',
  styleUrls: ['./cryptogramme-info.component.scss']
})
export class CryptogrammeInfoComponent implements OnInit {

  constructor(private dialod: MatDialog) { }

  ngOnInit(): void {
  }
  close() {
    this.dialod.closeAll();
  }
}
