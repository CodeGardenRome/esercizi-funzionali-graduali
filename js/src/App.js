import _ from 'lodash';
import {List, Range} from 'immutable';

export const ZeroA = () => {
    return _.range(1,4);
};

export const ZeroB = () => {
    return _.range(2,10,2);
};

export const ZeroC = () => {
    return _.range(7,100,7);
};

export const ZeroD = uomini => {
    return _.filter(uomini, (s) => s.startsWith("C"));
};

export const ZeroE = () => {
    return _.mean(_.range(8,100,8));
};

export const ZeroF = () => {
    return _.sum(_.range(6,1000,6));
};

export const ZeroG = uomini => {
    return List(uomini).sort();
};
