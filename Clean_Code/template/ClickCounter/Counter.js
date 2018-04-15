var ClickCounter  = (data) => {
    if(!data) throw Error();

    let counter = 0;

    return {
        getCounter(){
            return counter;
        },
        increase(){
            counter++;
        }
    }
}