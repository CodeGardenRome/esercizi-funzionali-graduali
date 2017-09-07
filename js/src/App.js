
var _ = require('lodash');

export const UOMINI = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
export const DONNE = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];

export const pippo = () => {
    return true;
};

export const kataZeroA = () => {
    return _.range(1,4);
};

export const kataZeroB = () => {
    return _.range(2,10,2)
};

export const kataZeroC = () => {
    return _.range(7,100,7)
};

export const kataZeroD = () => {
    return _.filter(UOMINI, (s) => s.startsWith("C"));
};

export const kataZeroE = () => {
    return _.mean(_.range(8,100,8));
};

export const kataZeroF = () => {
    return _.sum(_.range(6,1000,6));
};
