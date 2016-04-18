$(document).ready(function() {
    $('#TallerServlet').bootstrapValidator({
    	 feedbackIcons: {
    		 valid: 'glyphicon glyphicon-ok',
    		 invalid: 'glyphicon glyphicon-remove',
    		 validating: 'glyphicon glyphicon-refresh'
    	 },
    	 fields: {
    		 nombre: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El nombre es requerido'
    				 },
                     stringLength: {
                         max: 100,
                         message: 'El nombre debe contener maximo 100 caracteres'
                     }
    			 }
    		 },
    		 apellido: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El apellido es requerido'
    				 },
                     stringLength: {
                         max: 100,
                         message: 'El apellido debe contener maximo 100 caracteres'
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
                         max: 50,
                         message: 'El mail debe contener maximo 50 caracteres'
                     }
                 }   
             },
             telefono: {
                 validators: {
                     notEmpty: {
                         message: 'El telefono es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El telefono debe contener maximo 20 caracteres'
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
                         message: 'La region es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La region debe contener maximo 20 caracteres'
                     }
                 }
             },
             ciudad: {
                 validators: {
                     notEmpty: {
                         message: 'La ciudad es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La ciudad debe contener maximo 20 caracteres'
                     }
                 }
             },
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
                         message: 'El id debe contener maximo 10 caracteres'
                     },
                     regexp: {
                         regexp: /^[0-9]+$/,
                         message: 'El id solo puede contener números'
                     }
                 }
             },
             nombre: {
                 validators: {
                     notEmpty: {
                         message: 'El nombre es requerido'
                     },
                     stringLength: {
                         max: 100,
                         message: 'El nombre debe contener maximo 100 caracteres'
                     }
                 }
             },
             apellido: {
                 validators: {
                     notEmpty: {
                         message: 'El apellido es requerido'
                     },
                     stringLength: {
                         max: 100,
                         message: 'El apellido debe contener maximo 100 caracteres'
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
                         max: 50,
                         message: 'El mail debe contener maximo 50 caracteres'
                     }
                 }   
             },
             telefono: {
                 validators: {
                     notEmpty: {
                         message: 'El telefono es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'El telefono debe contener maximo 20 caracteres'
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
                         message: 'La region es requerida'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La region debe contener maximo 20 caracteres'
                     }
                 }
             },
             ciudad: {
                 validators: {
                     notEmpty: {
                         message: 'La ciudad es requerido'
                     },
                     stringLength: {
                         max: 20,
                         message: 'La ciudad debe contener maximo 20 caracteres'
                     }
                 }
             },
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
                         max: 20,
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
                        max: 20,
                        message: 'El id debe contener maximo 10 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La pass es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El id debe contener maximo 10 caracteres'
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
                        message: 'El id debe contener maximo 10 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La pass es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El id debe contener maximo 10 caracteres'
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
                        message: 'El id debe contener maximo 10 caracteres'
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
                        message: 'El id debe contener maximo 10 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La pass es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El id debe contener maximo 10 caracteres'
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
                        message: 'El id debe contener maximo 10 caracteres'
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
                        message: 'El id debe contener maximo 10 caracteres'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'La pass es requerida'
                    },
                    stringLength: {
                        max: 20,
                        message: 'El id debe contener maximo 10 caracteres'
                    }
                }
            }
        }
   });
});