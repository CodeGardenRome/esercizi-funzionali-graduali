import expect from 'expect'
import {pippo,kataZeroA,kataZeroB,kataZeroC,kataZeroD,kataZeroE,kataZeroF} from './App'

it('pippo torna true', () => {
    expect(pippo()).toBe(true);
});

it('kataZeroA restituisce [1,2,3]', () =>{
    expect(kataZeroA()).toEqual([1,2,3]);
})

it('kataZeroB restituisce i pari minori di 10', () =>{
    expect(kataZeroB()).toEqual([ 2, 4, 6, 8 ]);
})

it('kataZeroC restituisce i multipli di 7 minori di 100', () =>{
    expect(kataZeroC()).toEqual([ 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98 ]);
})

it('kataZeroD restituisce gli uomini che cominciano per C', () =>{
    expect(kataZeroD()).toEqual([ 'Caio', 'Calpurnio' ]);
})

it('kataZeroE restituisce la media dei multipli di 8 inferiori a 100', () =>{
    expect(kataZeroE()).toEqual(52);
})

it('kataZeroF restituisce la somma dei multipli di 6 inferiori a 100', () =>{
    expect(kataZeroF()).toEqual(83166);
})
