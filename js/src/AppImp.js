import {
    List,
    Range,
    Set
} from 'immutable';

export const ZeroA = () => {
    let out = [];
    for (let i = 1; i <= 3; i++) {
        out.push(i);
    }

    return out;
};

export const ZeroB = () => {
    let out = [];
    for(let i=2; i < 10; i+=2){
        out.push(i);
    }

    return out;
};

export const ZeroC = () => {
    let out = [];
    for(let i=7; i <= 100; i+=7){
        out.push(i);
    }

    return out;
}

export const ZeroD = uomini => {
    let out = [];
    for(let i=0; i <= uomini.length; i++){
        let s = uomini[i];
        if( typeof s === 'string' && s.startsWith("C")){
            out.push(s);
        }
    }

    return out;
}

export const ZeroE = () => {
    let out = [];
    let count = 0;
    let sum = 0;
    for(let i=8; i<100; i+=8){
        count++;
        sum+=i;
    }
    return sum/count;
}

export const ZeroF = () => {
    let sum = 0;
    for(let i=6; i<1000; i+=6){
        sum += i;
    }
    return sum;
}

export const ZeroG = uomini => {
    let copiaUomini = uomini.slice();
    return copiaUomini.sort();
}

export const ZeroH = () => {
    let out = [];
    for(let i=41;i<1000;i+=41){
        out.push(i);
    }
    let j = Math.floor(Math.random()*out.length);
    return out[j];
}

export const ZeroI = uomini => {
    let out = "";
    for(let i=0; i < uomini.length; i++){
        if(i!=0){
            out += ', ';
        }
        out += uomini[i];
    }
    return out;
}

export var ZeroJ = uomini => {
    return Set(uomini);
}

export const ZeroK = donne => {
    let out = {};
    for(let i=0; i < donne.length; i++){
      let donna = donne[i];
      if( out.hasOwnProperty( donna.length ) ){
        out[donna.length].push(donna);
      }else{
        out[donna.length] = [donna];
      }
    }
    return out;
}

export const ZeroL = donne => {
    let out = [];
    for(let i=0; i<donne.length; i++){
        out.push(donne[i].length);
    }
    return out;
}

export const ZeroM = donne => {
    let out = [];
    for(let i=0; i<donne.length; i++){
        out.push(donne[i][0]);
    }
    return out;
}
