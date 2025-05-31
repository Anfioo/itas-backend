import axios from '../../utils/axios'

export function addGrade(data) {
    return axios.post('/admin/grade', data)
}

export function getGradePage(params) {
    return axios.get('/admin/grade/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchGrade(ids) {
    return axios.delete('/admin/grade/batch', {
        data: ids
    });
} 