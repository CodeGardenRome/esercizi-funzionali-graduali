import expect from 'expect';
import * as kata from './AppImp';

export const UOMINI = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
export const DONNE = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];


it('kata.ZeroA restituisce [1,2,3]', () => {
    expect(kata.ZeroA()).toEqual([1, 2, 3]);
});
