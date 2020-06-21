import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Gasto } from './gasto.model';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
    providedIn: 'root'
})
export class GastoService {

    baseUrl="/api/gastos";

    constructor(
        private http: HttpClient,
        private matSnackBar: MatSnackBar
    ) { }

    buscarTodos(): Observable<Gasto[]> {
        return this.http.get<Gasto[]>(`${this.baseUrl}/buscarTodos`);
    }

    cadastrarGasto(gasto: Gasto): Observable<Gasto> {
        return this.http.post<Gasto>(`${this.baseUrl}/salvar`, gasto)
    }

    exibirMensagem(msg: string): void {
      this.matSnackBar.open(msg, '', {
        duration: 8000,
        horizontalPosition: "right",
        verticalPosition: "top",
        panelClass: ['my-snack-bar']
      })
    }

    buscarPorId(id: string): Observable<Gasto> {
        return this.http.get<Gasto>(`${this.baseUrl}/buscarPorId/${id}`)
    }

    excluirPorId(id: number): Observable<{}> {
        return this.http.delete(`${this.baseUrl}/excluirPorId/${id}`)
    }

}
