import { LLDDHealthProblem } from "../lldd-health-problem";


export class LLDDHealthProblemDTO {
    public id: number;
    public code:string;
    public description:string;
    public shortDescription :string;

    constructor(data: LLDDHealthProblem) {
        this.id = data.id;
        this.code = data.code;
        this.description = data.description;
        this.shortDescription = data.shortDescription;
    }
}