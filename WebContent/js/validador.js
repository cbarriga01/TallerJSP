$(document).ready(function() {
    $('#TallerServlet').bootstrapValidator({
    	 feedbackIcons: {
    		 valid: 'glyphicon glyphicon-ok',
    		 invalid: 'glyphicon glyphicon-remove',
    		 validating: 'glyphicon glyphicon-refresh'
    	 },
    	 fields: {
    		 run: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El run es requerido'
    				 },
                     stringLength: {
                         max: 12,
                         message: 'El run debe contener máximo 12 caracteres'
                     }
    			 }
    		 },
    		 nombre: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El nombre es requerido'
    				 },
                     stringLength: {
                         max: 50,
                         message: 'El nombre debe contener máximo 50 caracteres'
                     },
                     regexp: {
                         regexp: /^[a-zA-Z]+$/,
                         message: 'El nombre solo puede tener letras'
                     }
    			 }
    		 },
    		 apellido: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El apellido es requerido'
    				 },
                     stringLength: {
                         max: 50,
                         message: 'El apellido debe contener máximo 50 caracteres'
                     }
    			 }
    		 },
    		 mail: {
                 validators: {
                     notEmpty: {
                         message: 'El mail es requerido y no puede ser vacio'
                     },
                     emailAddress: {
                         message: 'El mail no es valido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El mail debe contener máximo 20 caracteres'
                     }
                 }   
             },
             telefono: {
                 validators: {
                     notEmpty: {
                         message: 'El teléfono es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El teléfono debe contener máximo 20 caracteres'
                     },
                     regexp: {
                         regexp: /^[0-9]+$/,
                         message: 'El teléfono solo puede contener números'
                     }
                 }
             },
             pais: {
                 validators: {
                     notEmpty: {
                         message: 'El país es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El país debe contener máximo 20 caracteres'
                     }
                 }
             },
             region: {
                 validators: {
                     notEmpty: {
                         message: 'La región es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La región debe contener máximo 20 caracteres'
                     }
                 }
             },
             ciudad: {
                 validators: {
                     notEmpty: {
                         message: 'La ciudad es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La ciudad debe contener máximo 20 caracteres'
                     }
                 }
             },
             direccion: {
                 validators: {
                     notEmpty: {
                         message: 'La dirección es requerida'
                     },
                     stringLength: {
                         max: 30,
                         message: 'La direccion debe contener máximo 30 caracteres'
                     }
                 }
             }
    	 }
    });

    $('#ServletActualizar').bootstrapValidator({
         feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
             id: {
                 validators: {
                     notEmpty: {
                         message: 'El id es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El id debe contener máximo 10 caracteres'
                     },
                     regexp: {
                         regexp: /^[0-9]+$/,
                         message: 'El id solo puede contener números'
                     }
                 }
             },
             run: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El run es requerido'
    				 },
                     stringLength: {
                         max: 12,
                         message: 'El run debe contener máximo 12 caracteres'
                     }
    			 }
    		 },
    		 nombre: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El nombre es requerido'
    				 },
                     stringLength: {
                         max: 50,
                         message: 'El nombre debe contener máximo 50 caracteres'
                     },
                     regexp: {
                         regexp: /^[a-zA-Z]+$/,
                         message: 'El nombre solo puede tener letras'
                     }
    			 }
    		 },
    		 apellido: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El apellido es requerido'
    				 },
                     stringLength: {
                         max: 50,
                         message: 'El apellido debe contener máximo 50 caracteres'
                     }
    			 }
    		 },
    		 mail: {
                 validators: {
                     notEmpty: {
                         message: 'El correo es requerido y no puede ser vacio'
                     },
                     emailAddress: {
                         message: 'El correo electronico no es valido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El correo debe contener máximo 20 caracteres'
                     }
                 }   
             },
             telefono: {
                 validators: {
                     notEmpty: {
                         message: 'El teléfono es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El teléfono debe contener máximo 20 caracteres'
                     },
                     regexp: {
                         regexp: /^[0-9]+$/,
                         message: 'El teléfono solo puede contener números'
                     }
                 }
             },
             pais: {
                 validators: {
                     notEmpty: {
                         message: 'El país es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El país debe contener máximo 20 caracteres'
                     }
                 }
             },
             region: {
                 validators: {
                     notEmpty: {
                         message: 'La región es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La región debe contener máximo 20 caracteres'
                     }
                 }
             },
             ciudad: {
                 validators: {
                     notEmpty: {
                         message: 'La ciudad es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La ciudad debe contener máximo 20 caracteres'
                     }
                 }
             },
             direccion: {
                 validators: {
                     notEmpty: {
                         message: 'La dirección es requerida'
                     },
                     stringLength: {
                         max: 30,
                         message: 'La dirección debe contener máximo 30 caracteres'
                     }
                 }
             }
    	 }
    });

    $('#ServletEliminar').bootstrapValidator({
         feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
             id: {
                 validators: {
                     notEmpty: {
                         message: 'El id es requerido'
                     },
                     stringLength: {
                         max: 10,
                         message: 'El id debe contener máximo 10 caracteres'
                     },
                     regexp: {
                         regexp: /^[0-9]+$/,
                         message: 'El id solo puede contener números'
                     }
                 }
             }
         }
    });
    
    $('#ServletLogin').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de usuario es requerido'
                    },
                    stringLength: {
                    	min: 4,
                        message: 'El nombre de usuario debe contener mínimo 4 caracteres',
                        max: 20,
                        message: 'El nombre de usuario debe contener máximo 20 caracteres'                        
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La contraseña debe contener máximo 20 caracteres'
                    }
                }
            }
        }
   });
    
    $('#ServletRegistrarUsuario').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de usuario es requerido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El nombre de usuario debe contener máximo 20 caracteres',
                        min: 2,
                        message: 'El nombre de usuario debe contener mínimo 2 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La contraseña debe contener máximo 20 caracteres'
                    }
                }
            }
        }
   });
    
    $('#ServletActualizarUsuario').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	id: {
                validators: {
                    notEmpty: {
                        message: 'El id es requerido'
                    },
                    stringLength: {
                        max: 10,
                        message: 'El id debe contener máximo 10 caracteres'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El id solo puede contener números'
                    }
                }
            },
        	user: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de usuario es requerido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El nombre de usuario debe contener máximo 20 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La contraseña debe contener máximo 20 caracteres'
                    }
                }
            }
        }
   });
    
    $('#ServletEliminarUsuario').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	id: {
                validators: {
                    notEmpty: {
                        message: 'El id es requerido'
                    },
                    stringLength: {
                        max: 10,
                        message: 'El id debe contener máximo 10 caracteres'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El id solo puede contener números'
                    }
                }
            },
        	user: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de usuario es requerido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El nombre de usuario debe contener máximo 20 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La contraseña debe contener máximo 20 caracteres'
                    }
                }
            }
        }
   });
    
    $('#ServletRegistrarEmpresa').bootstrapValidator({
   	 feedbackIcons: {
   		 valid: 'glyphicon glyphicon-ok',
   		 invalid: 'glyphicon glyphicon-remove',
   		 validating: 'glyphicon glyphicon-refresh'
   	 },
   	 fields: {
   		rut: {
  			 validators: {
  				 notEmpty: {
  					 message: 'El rut es requerido'
  				 },
                   stringLength: {
                       max: 12,
                       message: 'El rut debe contener máximo 12 caracteres'
                   }
  			 	}
         },
         razonSocial: {
   			 validators: {
   				 notEmpty: {
   					 message: 'La razón social es requerida'
   				 },
                    stringLength: {
                        max: 30,
                        message: 'La razón social debe contener máximo 30 caracteres'
                    }
   			 	}
         },
   		 nombre: {
   			 validators: {
   				 notEmpty: {
   					 message: 'El nombre es requerido'
   				 },
                    stringLength: {
                        max: 30,
                        message: 'El nombre debe contener máximo 30 caracteres'
                    }
   			 	}
            },
            representante: {
      			 validators: {
      				 notEmpty: {
      					 message: 'El representante es requerido'
      				 },
                       stringLength: {
                           max: 50,
                           message: 'El representante debe contener máximo 50 caracteres'
                       }
      			 	}
            },
            mail: {
                validators: {
                    notEmpty: {
                        message: 'El correo electrónico es requerido y no puede ser vacio'
                    },
                    emailAddress: {
                        message: 'El correo electrónico no es valido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El correo electrónico debe contener máximo 20 caracteres'
                    }
                }   
            },
            telefono: {
                validators: {
                    notEmpty: {
                        message: 'El teléfono es requerido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El teléfono debe contener máximo 20 caracteres'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El teléfono solo puede contener números'
                    }
                }
            },
            pais: {
                validators: {
                    notEmpty: {
                        message: 'El país es requerido'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El país debe contener maximo 20 caracteres'
                    }
                }
            },
            region: {
                validators: {
                    notEmpty: {
                        message: 'La región es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La región debe contener maximo 20 caracteres'
                    }
                }
            },
            ciudad: {
                validators: {
                    notEmpty: {
                        message: 'La ciudad es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'La ciudad debe contener máximo 20 caracteres'
                    }
                }
            },
            domicilio: {
                validators: {
                    notEmpty: {
                        message: 'El domicilio es requerido'
                    },
                    stringLength: {
                        max: 30,
                        message: 'El domicilio debe contener máximo 30 caracteres'
                    }
                }
            }
   	 	}
   });

   $('#ServletActualizarEmpresa').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            id: {
                validators: {
                    notEmpty: {
                        message: 'El id es requerido'
                    },
                    stringLength: {
                        max: 10,
                        message: 'El id debe contener máximo 10 caracteres'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El id solo puede contener números'
                    }
                }
            },
            rut: {
     			 validators: {
     				 notEmpty: {
     					 message: 'El rut es requerido'
     				 },
                      stringLength: {
                          max: 12,
                          message: 'El rut debe contener máximo 12 caracteres'
                      }
     			 	}
            },
            razonSocial: {
      			 validators: {
      				 notEmpty: {
      					 message: 'La razón social es requerida'
      				 },
                       stringLength: {
                           max: 20,
                           message: 'La razón social debe contener máximo 30 caracteres'
                       }
      			 	}
            },
      		 nombre: {
      			 validators: {
      				 notEmpty: {
      					 message: 'El nombre es requerido'
      				 },
                       stringLength: {
                           max: 30,
                           message: 'El nombre debe contener máximo 30 caracteres'
                       }
      			 	}
               },
               representante: {
         			 validators: {
         				 notEmpty: {
         					 message: 'El representante es requerido'
         				 },
                          stringLength: {
                              max: 50,
                              message: 'El representante debe contener máximo 50 caracteres'
                          }
         			 	}
               },
               mail: {
                   validators: {
                       notEmpty: {
                           message: 'El correo electrónico es requerido y no puede ser vacio'
                       },
                       emailAddress: {
                           message: 'El correo electrónico no es valido'
                       },
                       stringLength: {
                           max: 20,
                           message: 'El correo electrónico debe contener máximo 20 caracteres'
                       }
                   }   
               },
               telefono: {
                   validators: {
                       notEmpty: {
                           message: 'El teléfono es requerido'
                       },
                       stringLength: {
                           max: 20,
                           message: 'El teléfono debe contener máximo 20 caracteres'
                       },
                       regexp: {
                           regexp: /^[0-9]+$/,
                           message: 'El teléfono solo puede contener números'
                       }
                   }
               },
               pais: {
                   validators: {
                       notEmpty: {
                           message: 'El pais es requerido'
                       },
                       stringLength: {
                           max: 20,
                           message: 'El pais debe contener maximo 20 caracteres'
                       }
                   }
               },
               region: {
                   validators: {
                       notEmpty: {
                           message: 'La región es requerida'
                       },
                       stringLength: {
                           max: 20,
                           message: 'La región debe contener maximo 20 caracteres'
                       }
                   }
               },
               ciudad: {
                   validators: {
                       notEmpty: {
                           message: 'La ciudad es requerida'
                       },
                       stringLength: {
                           max: 20,
                           message: 'La ciudad debe contener maximo 20 caracteres'
                       }
                   }
               },
               domicilio: {
                   validators: {
                       notEmpty: {
                           message: 'El domicilio es requerido'
                       },
                       stringLength: {
                           max: 30,
                           message: 'El domicilio debe contener maximo 30 caracteres'
                       }
                   }
               }
      	 }
   });

   $('#ServletEliminarEmpresa').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            id: {
                validators: {
                    notEmpty: {
                        message: 'El id es requerido'
                    },
                    stringLength: {
                        max: 10,
                        message: 'El id debe contener maximo 10 caracteres'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El id solo puede contener números'
                    }
                }
            }
        }
   });
});