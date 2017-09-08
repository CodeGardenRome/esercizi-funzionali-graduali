import expect from 'expect';
import * as kata from './App';
import {
    List,
    Set,
    OrderedMap
} from 'immutable';
import freeze from 'deep-freeze';

export const UOMINI = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
export const DONNE = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];


it('kata.ZeroA restituisce [1,2,3]', () => {
    expect(kata.ZeroA()).toEqual([1, 2, 3]);
});

it('kata.ZeroB restituisce i pari minori di 10', () => {
    expect(kata.ZeroB()).toEqual([2, 4, 6, 8]);
});

it('kata.ZeroC restituisce i multipli di 7 minori di 100', () => {
    expect(kata.ZeroC()).toEqual([7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98]);
});

it('kata.ZeroD restituisce gli uomini che cominciano per C', () => {
    expect(kata.ZeroD(freeze(UOMINI))).toEqual(['Caio', 'Calpurnio']);
});

it('kata.ZeroE restituisce la media dei multipli di 8 inferiori a 100', () => {
    expect(kata.ZeroE()).toEqual(52);
});

it('kata.ZeroF restituisce la somma dei multipli di 6 inferiori a 100', () => {
    expect(kata.ZeroF()).toEqual(83166);
});

it('kata.ZeroG restituisce una lista ordinata di nomi di uomini', () => {
    expect(kata.ZeroG(freeze(UOMINI)))
        .toEqual(
            List(['Caio', 'Calpurnio', 'Filano', 'Mevio', 'Sempronio', 'Tizio']));
});

it('kata.ZeroH restituisce un elemento a caso dei multipli di 41', () => {
    const res = kata.ZeroH();
    expect(res % 41).toEqual(0);
});

it('kata.ZeroF trasforma l\'elenco dei nomi di uomini in una stringa separati da virgola', () => {
    expect(kata.ZeroI(freeze(UOMINI))).toEqual("Tizio, Caio, Sempronio, Mevio, Filano, Calpurnio");
});

it('kata.ZeroJ ritorna un set di nomi di uomini', () => {
    expect(kata.ZeroJ(freeze(UOMINI))).toEqual(Set(UOMINI));
});

it('kata.ZeroK ritorna i nomi delle donne raggruppati per la loro lunghezza', () => {
    expect(kata.ZeroK(DONNE)).toEqual(OrderedMap({
        4: List(["Anna", "Emma", "Sara"]),
        5: List(["Carla", "Maria"]),
        6: List(["Angela", "Chiara"])
    }));
});

it('kata.ZeroL ritorna una lista con la lungezza di ogni nome di donna', () => {
    expect(kata.ZeroL(DONNE)).toEqual(List([4, 5, 6, 6, 4, 5, 4]));
});

it('kata.ZeroM ritorna una lista con la sequenza delle iniziali del nome delle donne', () => {
    expect(kata.ZeroM(DONNE)).toEqual(List(['A', 'C', 'A', 'C', 'E', 'M', 'S']));
});
