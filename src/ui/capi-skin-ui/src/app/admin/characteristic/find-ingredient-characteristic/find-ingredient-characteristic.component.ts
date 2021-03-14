import { Component, OnInit } from '@angular/core';
import { IngredientService } from 'src/app/service/ingredient.service';
import { IngredientDto } from 'src/app/modal/rest';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-find-ingredient-characteristic',
  templateUrl: './find-ingredient-characteristic.component.html',
  styleUrls: ['./find-ingredient-characteristic.component.scss']
})
export class FindIngredientCharacteristicComponent implements OnInit {
 ingredientDto: IngredientDto = {} as IngredientDto;
 idIngredient: number;

  constructor(private ingredientService: IngredientService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => {
        this.idIngredient = this.route.snapshot.params.idIngredient;
        this.ingredientService.findIngredient(this.idIngredient).subscribe((ingredientDto) => {
         this.ingredientDto = ingredientDto;
        })
      }
    )
   }

  ngOnInit(): void {
  }

}
