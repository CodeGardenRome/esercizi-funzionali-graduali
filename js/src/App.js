import freeze from 'deep-freeze';
import _ from 'lodash';
import {List, Range} from 'immutable'; //todo estrai solo quello che utilizzi

export const UOMINI = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
export const DONNE = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];

export const ZeroA = () => {
    return _.range(1,4);
};

export const ZeroB = () => {
    return _.range(2,10,2);
};

export const ZeroC = () => {
    return _.range(7,100,7);
};

export const ZeroD = () => {
    return _.filter(UOMINI, (s) => s.startsWith("C"));
};

export const ZeroE = () => {
    return _.mean(_.range(8,100,8));
};

export const ZeroF = () => {
    return _.sum(_.range(6,1000,6));
};

export const ZeroG = () => {
    return List(freeze(UOMINI)).sort();
};
