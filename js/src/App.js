import _ from 'lodash';
import {
    List,
    Range,
    Set
} from 'immutable';

export const ZeroA = () => {
    return _.range(1, 4);
};

export const ZeroB = () => {
    return _.range(2, 10, 2);
};

export const ZeroC = () => {
    return _.range(7, 100, 7);
};

export const ZeroD = uomini => {
    return _.filter(uomini, (s) => s.startsWith("C"));
};

export const ZeroE = () => {
    return _.mean(_.range(8, 100, 8));
};

export const ZeroF = () => {
    return _.sum(_.range(6, 1000, 6));
};

export const ZeroG = uomini => {
    return List(uomini).sort();
};

export const ZeroH = () => {
    const range = Range(41, 1000, 41);
    return range.get(_.random(0, range.count() - 1));
};

export const ZeroI = uomini => {
    return List(uomini).join(', ');
};

export const ZeroJ = uomini => {
    return Set(uomini);
};

export const ZeroK = donne => {
    return List(donne).groupBy(x => x.length.toString());
};

export const ZeroL = donne => {
    return List(donne).map(x => x.length);
};

export const ZeroM = donne => {
    return List(donne).map(x => x[0]);
};
