export class Category {
  id: number;
  name: string;
}


export interface Category {
  id: number;
  nextLevelCategory: NextLevelCategory;
}

export interface NextLevelCategory {
  id: number;
  name: string;
}
