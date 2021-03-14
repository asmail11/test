/* tslint:disable */

export interface AccountDto {
  address: string;
  city: string;
  codePostale: string;
  conditionAccept: string;
  gender: string;
  id: number;
  name: string;
  phone: string;
}

export interface ActifDto extends PersistableElementDto {
  price: number;
}

export interface BaseProductDto extends PersistableElementDto {
  ingredientProduct: IngredientProductDto;
  price: number;
}

export interface BodyFaceHairDto extends PersistableElementDto {
  types: TypeDto[];
}

export interface CharacteristicDto extends PersistableElementDto {
  actifs: ActifDto[];
  characteristics: CharacteristicDto[];
  essentialOils: EssentialOilDto[];
  needs: NeedsDto[];
  products: IngredientDto[];
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
  price: number;
}

export interface FinalProductDto extends PersistableElementDto {
  ingredientProducts: IngredientProductDto[];
}

export interface IngredientDto extends PersistableElementDto {
  price: number;
}

export interface IngredientProductDto extends PersistableElementDto {
  finalProducts: FinalProductDto[];
  millilimter: number;
  price: number;
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
}

export interface PaymentDto {
  cartNumber: string;
  cryptogram: number;
  expiry: string;
  id: number;
  nameOnCard: string;
}

export interface PersistableElementDto {
  createdAt: Date;
  description: string;
  id: number;
  name: string;
  photo: string;
  updatedAt: Date;
}

export interface RoleDto {
  id: number;
  name: RoleName;
}

export interface TypeDto extends PersistableElementDto {
  characteristics: CharacteristicDto[];
}

export interface UserDto {
  account: AccountDto;
  admin: boolean;
  bodyFaceHairs: BodyFaceHairDto[];
  commands: CommandDto[];
  createdAt: Date;
  email: string;
  id: number;
  password: string;
  payment: PaymentDto;
  token: string;
  type: string;
  roles: RoleDto[];
  username: string;
}

export const enum RoleName {
  ROLE_USER = 'ROLE_USER',
  ROLE_LABORATORY = 'ROLE_LABORATORY',
  ROLE_ADMIN = 'ROLE_ADMIN',
}
