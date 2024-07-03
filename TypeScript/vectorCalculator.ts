// just javascript but with type annotations (aka
// : number
// or
// : number[]
// lol
export function getForwardVector(pitch: number, yaw: number): number[] {
    let r: number[] = [
        Math.cos(pitch) * Math.sin(yaw),
        Math.sin(pitch) * -1, 
        Math.cos(pitch) * Math.cos(yaw) 
    ];
    return r;
}

export function getRightVector(yaw: number): number[] {
    let r: number[] = [
        Math.cos(yaw),
        0.0,
        Math.sin(yaw) * -1
    ];
    return r;
}

export function getUpVector(pitch: number, yaw: number): number {
    return cross(
        getForwardVector(pitch, yaw),
        getRightVector(yaw)
    );
}

function cross(v1, v2): number[] {
    let r = [0, 0, 0];
    for (let i = 0; i < 3; i++) {
        r[i] = v1[i] * v2[i];
    }
    return r;
}
