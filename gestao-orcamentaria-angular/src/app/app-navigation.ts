export const navigation = [
  {
    text: 'Home',
    path: '/home',
    icon: 'home'
  },
  {
    text: 'Cadastros Iniciais',
    icon: 'folder',
    items: [
      {
        text: 'Tipo Receita',
        path: '/cadastro-receita'
      },
      {
        text: 'Tipo Despesa',
        path: '/cadastro-despesa'
      }
    ]
  },
  {
    text: 'Cadastro Pessoas',
    icon: 'folder',
    items: [
      {
        text: 'Funcionario',
        path: '/cadastro-funcionario'
      },
      {
        text: 'Fornecedor',
        path: '/cadastro-fornecedor'
      }
    ]
  },
  {
    text: 'Movimentos',
    icon: 'folder',
    items: [
      {
        text: 'Movimentos Financeiros',
        path: '/movimentos-financeiros'
      }
    ]
  },
];
