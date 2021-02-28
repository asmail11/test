/* tslint:disable */

export interface ActifDto extends PersistableElementDto {
  name: string;
}

export interface BaseProductDto extends PersistableElementDto {
  name: string;
  price: number;
}

export interface BodyAndHairDto extends PersistableElementDto {
  faceAndCares: FaceAndCareDto[];
  name: string;
}

export interface CategoryDto extends PersistableElementDto {
  bodyAndHairs: BodyAndHairDto[];
  characteristics: CharacteristicDto[];
  name: string;
}

export interface CharacteristicDto extends PersistableElementDto {
  nature: string;
  needs: NeedsDto[];
  photo: string;
  problem: string;
  texture: string;
  treatment: string;
  type: string;
  visual: string;
}

export interface CommandDto extends PersistableElementDto {
  baseProduct: string;
  productName: string;
  status: boolean;
  total: number;
}

export interface ContentMillimiterDto extends PersistableElementDto {
  bigMillimiter: number;
  bigPrice: number;
  meduimMillimiter: number;
  meduimPrice: number;
  smallMillimiter: number;
  smallPrice: number;
}

export interface EssentialOilDto extends PersistableElementDto {
  name: string;
}

export interface FaceAndCareDto extends PersistableElementDto {
  ingredients: IngredientDto[];
  name: string;
}

export interface FinalProductDto extends PersistableElementDto {
  ingredientProducts: IngredientProductDto[];
}

export interface GrantedAuthority extends Serializable {
  authority: string;
}

export interface IngredientDto extends PersistableElementDto {
  name: string;
}

export interface IngredientProductDto extends PersistableElementDto {
  finalProducts: FinalProductDto[];
  millilimter: number;
  name: string;
  photo: string;
  price: number;
}

export interface JwtResponseDto {
  accessToken: string;
  authorities: GrantedAuthority[];
  email: string;
  id: number;
  name: string;
  tokenType: string;
  username: string;
}

export interface LoginFormDto {
  email: string;
  name: string;
  password: string;
  username: string;
}

export interface MailContactRequestDto {
  email: string;
  from: string;
  message: string;
  name: string;
  subject: string;
  to: string;
}

export interface MailRequestDto {
  from: string;
  name: string;
  subject: string;
  to: string;
}

export interface MailResponseDto {
  message: string;
  status: boolean;
}

export interface NeedsDto extends PersistableElementDto {
  baseProducts: BaseProductDto[];
  name: string;
}

export interface PersistableElementDto {
  createdAt: Date;
  description: string;
  id: number;
  updatedAt: Date;
}

export interface ResponseMessageDto {
  message: string;
}

export interface Serializable {
}

export interface SignUpFormDto {
  addresse: string;
  admin: boolean;
  email: string;
  from: string;
  id: number;
  name: string;
  password: string;
  phone: string;
  repassword: string;
  role: string[];
  subject: string;
  to: string;
  username: string;
}

export interface VegetableOilDto extends PersistableElementDto {
  amandeDouce: string;
  argan: string;
  avocat: string;
  baobab: string;
  bourrache: string;
  brocoli: string;
  coco: string;
  jojoba: string;
  karite: string;
  macadamia: string;
  mangue: string;
  neem: string;
  nigelle: string;
  olive: string;
  owala: string;
  pepinDeRisin: string;
  photo: string;
  piqui: string;
  price: number;
  ricin: string;
  sapote: string;
}
