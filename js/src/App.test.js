import expect from 'expect';
import * as kata from './App';
import {List} from 'immutable';

it('kataZeroA restituisce [1,2,3]', () => {
    expect(kata.ZeroA()).toEqual([1,2,3]);
})

it('kataZeroB restituisce i pari minori di 10', () => {
    expect(kata.ZeroB()).toEqual([ 2, 4, 6, 8 ]);
})

it('kataZeroC restituisce i multipli di 7 minori di 100', () => {
    expect(kata.ZeroC()).toEqual([ 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98 ]);
})

it('kataZeroD restituisce gli uomini che cominciano per C', () => {
    expect(kata.ZeroD()).toEqual([ 'Caio', 'Calpurnio' ]);
})

it('kataZeroE restituisce la media dei multipli di 8 inferiori a 100', () => {
    expect(kata.ZeroE()).toEqual(52);
})

it('kataZeroF restituisce la somma dei multipli di 6 inferiori a 100', () => {
    expect(kata.ZeroF()).toEqual(83166);
})

it('kataZeroG restituisce una lista ordinata di numi di uomini', () => {
    expect(kata.ZeroG())
        .toEqual(
            List(['Caio', 'Calpurnio', 'Filano', 'Mevio', 'Sempronio', 'Tizio']));
});
