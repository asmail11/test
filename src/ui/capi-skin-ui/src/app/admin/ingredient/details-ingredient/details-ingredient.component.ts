import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { IngredientDto } from '../../../modal/rest';
import { IngredientService } from '../../../service/ingredient.service';

@Component({
  selector: 'app-details-ingredient',
  templateUrl: './details-ingredient.component.html',
  styleUrls: ['./details-ingredient.component.scss']
})
export class DetailsIngredientComponent implements OnInit {
  productDto: IngredientDto = {} as IngredientDto;

  constructor(private ingredientService: IngredientService, @Inject(MAT_DIALOG_DATA) private data: any) { }

  ngOnInit(): void {
    this.ingredientService.findIngredient(this.data.idIngredient).subscribe((productDto) => {
     this.productDto = productDto;
    })
  }

}
