import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EssentialOilDto } from 'src/app/modal/rest';
import { EssentialOilService } from '../../../service/essential-oil.service';

@Component({
  selector: 'app-details-essential',
  templateUrl: './details-essential.component.html',
  styleUrls: ['./details-essential.component.scss']
})
export class DetailsEssentialComponent implements OnInit {
  productDto: EssentialOilDto = {} as EssentialOilDto;

  constructor(private essentialOilService: EssentialOilService, @Inject(MAT_DIALOG_DATA) private data: any) { }

  ngOnInit(): void {
    this.essentialOilService.findEssentialOil(this.data.idEssential).subscribe((productDto) => {
      this.productDto = productDto;
    })
  }

}
