import { Ethnicity } from "../ethnicity";

export class EthnicityDTO {
    public id: number;
    public code:string;
    public description:string;

    constructor(data: Ethnicity) {
        this.id = data.id;
        this.code = data.code;
        this.description = data.description;
    }
}