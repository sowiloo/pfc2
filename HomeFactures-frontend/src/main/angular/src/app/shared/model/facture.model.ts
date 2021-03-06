import { Moment } from 'moment';
import { IFournisseur } from './fournisseur.model';

export interface IFacture {
    id?: number,
    numClient?: string,
    numFacture?: number,
    dateDebut?: Moment,
    dateFin?: Moment,
    beneficiaire?: string,
    delai?: Moment,
    isPayed?: boolean,
    montant?: number,
    espaceService?: number,
    numRecu?: string,
    numTransaction?: string,
    reference?:string,
    fournisseur?: IFournisseur
}

export class Facture implements IFacture {
    constructor
        (
            id?: number,
            numClient?: string,
            numFacture?: string,
            dateDebut?: Moment,
            dateFin?: Moment,
            beneficiaire?: string,
            delai?: Moment,
            isPayed?: boolean,
            montant?: number,
            espaceService?: number,
            numRecu?: string,
            numTransaction?: string,
            reference?:string,
            fournisseur?: IFournisseur
        ) { }

}