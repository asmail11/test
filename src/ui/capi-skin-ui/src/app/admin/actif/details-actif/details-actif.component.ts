import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActifDto } from 'src/app/modal/rest';
import { ActifService } from '../../../service/actif.service';

@Component({
  selector: 'app-details-actif',
  templateUrl: './details-actif.component.html',
  styleUrls: ['./details-actif.component.scss']
})
export class DetailsActifComponent implements OnInit {
  productDto: ActifDto = {} as ActifDto;

  constructor(private actifService: ActifService, @Inject(MAT_DIALOG_DATA) private data: any) { }

  ngOnInit(): void {
    this.actifService.findActif(this.data.idActif).subscribe((productDto) => {
      this.productDto = productDto;
    })
  }

}
