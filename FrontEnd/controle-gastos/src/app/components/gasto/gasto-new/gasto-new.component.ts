import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GastoService } from '../gasto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gasto-new',
  templateUrl: './gasto-new.component.html',
  styleUrls: ['./gasto-new.component.css']
})
export class GastoNewComponent implements OnInit {

  mensagemObrigatoriedade = 'Campo obrigatório não preenchido.';

  formGroup: FormGroup;

  constructor(
    private builder: FormBuilder,
    private router: Router,
    private gastoService: GastoService,
  ) { }

  ngOnInit(): void {
    this.criarFormulario()
  }

  criarFormulario() {
    this.formGroup = this.builder.group({
      nomePessoa: [null, Validators.required],
      descricao: [null, Validators.required],
      dataHora: [null, Validators.required],
      valor: [null, Validators.required],
      tag: [null, Validators.required],
    });
  }

  salvar(): void {
    if(this.formGroup.valid){
      this.gastoService.cadastrarGasto(this.formGroup.value).subscribe(() => {
        this.gastoService.exibirMensagem('Gasto cadastrado com sucesso!!!')
        this.router.navigate(['/'])
      });
    }else{
      Object.keys(this.formGroup.controls).forEach(campo => {
        const controle = this.formGroup.get(campo)
        controle.markAllAsTouched()
      })
    }
  }

}
