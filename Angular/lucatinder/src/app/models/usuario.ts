export class Usuario {

    /*public idUsuario: number;
    public nombreUsuario: string;
    public descripcionUsuario: string;
    public edadUsuario: number;
    public ciudadUsuario: string;
    public sexoUsuario: boolean;
    public imagenUsuario: string;*/

    constructor(
        public nombreUsuario: string,
        public idUsuario?: number,
        public descripcionUsuario?: string,
        public edadUsuario?: number,
        public ciudadUsuario?: string,
        public sexoUsuario?: boolean,
        public imagenUsuario?: string,
    )
    {}
}
