// export class Transit {
//   id: number;
//   name: string;
//   category: {
//     id: number;
//     name: string;
//     nextLevelCategory: {
//       id: number;
//       name: string;
//     }
//   };
// }

import {Category} from './category.model';

export class Transit {
  id: number;
  name: string;
  category: Category;
  constructor (category: Category) {
    this.category = category;
  }
}

export interface Transit {
  name:     string;
  category: Category;
}
// Converts JSON strings to/from your types
export namespace Convert {
  export function toTransit(json: string): Transit {
    return JSON.parse(json);
  }

  export function transitToJson(value: Transit): string {
    return JSON.stringify(value, null, 2);
  }
}
