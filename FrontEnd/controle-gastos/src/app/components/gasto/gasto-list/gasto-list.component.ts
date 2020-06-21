import { Component, OnInit } from '@angular/core';
import { Gasto } from '../gasto.model';
import { GastoService } from '../gasto.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-gasto-list',
  templateUrl: './gasto-list.component.html',
  styleUrls: ['./gasto-list.component.css']
})
export class GastoListComponent implements OnInit {

  gastos: Gasto[];
  tableColumns = ['nomePessoa', 'descricao', 'dataHora', 'valor', 'acao'];

  constructor(private gastoService: GastoService) { }

  ngOnInit(): void {
    this.gastoService.buscarTodos().subscribe(gastos => {
      this.gastos = gastos;
    })
  }

  excluir(id: number) {
    this.gastoService.excluirPorId(id).subscribe(() => {
      this.ngOnInit();
    });
  }

}
