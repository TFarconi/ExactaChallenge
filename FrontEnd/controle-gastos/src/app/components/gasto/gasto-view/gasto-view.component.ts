import { Component, OnInit } from '@angular/core';
import { Gasto } from '../gasto.model';
import { GastoService } from '../gasto.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-gasto-view',
  templateUrl: './gasto-view.component.html',
  styleUrls: ['./gasto-view.component.css']
})
export class GastoViewComponent implements OnInit {

  gasto: Gasto;

  constructor(
    private gastoService: GastoService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id')
    this.gastoService.buscarPorId(id).subscribe(gasto => {
      this.gasto = gasto;
    })
  }

}
